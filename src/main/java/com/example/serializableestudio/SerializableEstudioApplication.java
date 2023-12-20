package com.example.serializableestudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.sampled.AudioInputStream;
import java.io.*;

@SpringBootApplication
public class SerializableEstudioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SerializableEstudioApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException, ClassNotFoundException {
		
		// la serialización sirve para convertir y desconvertir a byte, muy útil para mandar archivos por la red o para
		// leer/escribir archivos
		
		// el serialVersionUID debe ser el mismo con el que serializaron el objeto y con el que van a deserializar el objeto
		
		// ejemplo: si se serializa con una versión y se desserializa con otra versión fallará con InvalidClassException
		// serializar con serialVersionUID 3457911541638393113L
		//this.serializar();

		// desSerializar con serialVersionUID -3152424149383682736L
		this.desSerializar();
	}
	
	private void serializar() throws IOException {

		Persona persona = new Persona();
		persona.setEdad(30);
		persona.setNombre("Juan");
		// no se serializará y desserializará
		persona.setCiudad("Madrid");
		persona.setAnimalDomestico(new Animal("Blanquito"));

		//otras clases para escribir
		/*new ByteArrayOutputStream();
		new FileOutputStream();
		new FilterOutputStream();
		new ObjectOutputStream();
		new PipedOutputStream();*/

		// se dice que archivo vas a escribir
		FileOutputStream fileOutputStream = new FileOutputStream("fichero.txt");
		// lo convierte a cadena de bytes
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		// convierte el objeto a bytes para escribirlo en el archivo byte
		objectOutputStream.writeObject(persona);
		// debes decirle que ya terminaste y que liberas de edición este archivo
		objectOutputStream.close();		
	}
	private void desSerializar() throws IOException, ClassNotFoundException {

		//otras clases para leer
		/*new AudioInputStream();
		new ByteArrayInputStream();
		new FileInputStream();
		new FilterInputStream();
		new ObjectInputStream();
		new AudioInputStream();*/

		// se dice que archivo vas a leer
		FileInputStream fileInputStream = new FileInputStream("fichero.txt");
		// lo convierte a cadena de bytes
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		// convierte los bytes a objeto
		Persona persona = (Persona) objectInputStream.readObject();
		// debes decirle que ya terminaste y que liberas de edición este archivo
		objectInputStream.close();
		System.out.println(persona);
	}
}
