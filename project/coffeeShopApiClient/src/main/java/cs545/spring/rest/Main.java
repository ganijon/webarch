package cs545.spring.rest;

import org.apache.commons.cli.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

public class Main {


    public static void main(String[] args) {

        Options options = new Options();

        Option host = new Option("h", "host", true, "host name");
        host.setRequired(true);
        options.addOption(host);

        Option port = new Option("p", "port", true, "port number");
        port.setRequired(true);
        options.addOption(port);

        Option user = new Option("u", "user", true, "user name");
        user.setRequired(true);
        options.addOption(user);

        Option pwd = new Option("pw", "password", true, "password");
        pwd.setRequired(true);
        options.addOption(pwd);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
            return;
        }


        String hostUrl = cmd.getOptionValue("host");
        String portNo = cmd.getOptionValue("port");
        String userName = cmd.getOptionValue("user");
        String password = cmd.getOptionValue("password");

        ProductClient.REST_API_URI = getRestApiUrl(hostUrl, portNo);
        ProductClient.BASIC_AUTH_HTTP_HEADERS = getBasicAuthHttpHeaders(userName, password);

        ProductClient.getAllProducts();
        ProductClient.getProduct();

    }

    private static HttpHeaders getBasicAuthHttpHeaders(String userName, String password ){
        String plainCreds = userName + ":" + password;
        String base64Creds = Base64.encodeBase64String(plainCreds.getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }

    private static String getRestApiUrl(String hostUrl, String portNo ){
        return "http://" + hostUrl + ":" + portNo + "/api";
    }
}
