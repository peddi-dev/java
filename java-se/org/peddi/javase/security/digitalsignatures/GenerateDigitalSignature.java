package org.peddi.javase.security.digitalsignatures;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;

public class GenerateDigitalSignature {

	private static final String path = null;
	public static final String dataFile = path + "/DataFile";
	public static final String digitalSignFile = path + "digitalSignFile";
	public static final String publicKeyFile = path + "publicKeyFile";

	/**
	 * Digital Signature Algorithm (DSA) is used to generate digital signature
	 * 
	 * @param nameOfFileToSign
	 */
	public void generateSignature(String nameOfFileToSign) {
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");

			SecureRandom secRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");

			keyGen.initialize(1024, secRandom);

			KeyPair keyPair = keyGen.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();

			Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
			dsa.initSign(privateKey);

			try (var bufInStream = new BufferedInputStream(new FileInputStream(nameOfFileToSign))) {

				byte[] data = new byte[1024];
				int len;
				while ((len = bufInStream.read(data)) >= 0) {

					dsa.update(data, 0, len);
				}

			} catch (IOException e) {

				e.printStackTrace();
			}

			// generating digital signature of the file data
			byte[] digitalSignature = dsa.sign();
			System.out.println("digitalSignature: " + Arrays.toString(digitalSignature));
			// saving digital signature to the file
			try (var digitalSignFOS = new FileOutputStream(digitalSignFile)) {
				digitalSignFOS.write(digitalSignature);

			} catch (IOException e) {

				e.printStackTrace();
			}

			// saving the publicKey to the file
			byte[] encodedPubKey = publicKey.getEncoded();
			System.out.println("encodedPubKey: " + Arrays.toString(encodedPubKey));
			try (var publicKeyFOS = new FileOutputStream(publicKeyFile)) {
				publicKeyFOS.write(encodedPubKey);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {

			e.printStackTrace();
		} catch (InvalidKeyException e) {

			e.printStackTrace();
		} catch (SignatureException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		GenerateDigitalSignature app = new GenerateDigitalSignature();

		app.generateSignature(dataFile);

	}

}
