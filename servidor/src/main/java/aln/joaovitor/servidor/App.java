package aln.joaovitor.servidor;

import aln.joaovitor.controlador.QuizHandler;

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;


/**
 *
 */
public class App {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando servidor XML-RPC...");
            int port = 8000;

            // Cria o servidor web
            WebServer webServer = new WebServer(port);

            // Configura o servidor XML-RPC
            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
            PropertyHandlerMapping phm = new PropertyHandlerMapping();

            // Registra a classe MathHandler no servidor XML-RPC
            phm.addHandler("QuizHandler", QuizHandler.class);
            xmlRpcServer.setHandlerMapping(phm);

            XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);

            // Inicia o servidor web e o servidor XML-RPC
            webServer.start();
            System.out.println("Servidor iniciado com sucesso. Escutando na porta " + port);
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor XML-RPC: " + e.getMessage());
        }
    }
}
