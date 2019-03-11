package es.urjc.etsii.dad.hsdcks.ServicioInterno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class App 
{
    public static void main( String[] args )
    {
       

		System.out.println("Estamos activos");
		
		int puertoServidor = 5555;
		
		
		String email;
		
		
		while(true) {
			
			System.out.println("Esperando una conexion en el puerto: " + puertoServidor);
			
			
			try {
			
			ServerSocket serverSocket = new ServerSocket(puertoServidor);	
			Socket fromClientSocket = serverSocket.accept();	
			
			PrintWriter pw = new PrintWriter(fromClientSocket.getOutputStream(), true);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fromClientSocket.getInputStream()));
			
			
			email = br.readLine();
			System.out.println("El email recibido es: " + email);
			
			
			String destinatario = email; //A quien le quieres escribir.
		    String asunto = "Correo de prueba enviado desde Java";
		    String cuerpo = "Esta es una prueba de correo...";

		    enviarConGMail(destinatario, asunto, cuerpo);
			
			
			pw.close();
			br.close();
			fromClientSocket.close();
			serverSocket.close();
			
			} catch (IOException e) {
				System.out.println("Fallo en la conexion");
			}
			
		}
	}
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitente = "deckshearthstone0";  //Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "Hsd1234567");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "Hsd1234567");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
	
}
