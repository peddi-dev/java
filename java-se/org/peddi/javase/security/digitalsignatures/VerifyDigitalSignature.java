package org.peddi.javase.security.digitalsignatures;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class VerifyDigitalSignature {

	public void verifyDigitalSignature(String publicKeyFile, String digitalSignFile, String dataFile) {

		try {

			// read the public key from file
			byte[] pubKeyBytes = null;
			try (var pkFIS = new BufferedInputStream(new FileInputStream(publicKeyFile))) {
				pubKeyBytes = new byte[pkFIS.available()];
				pkFIS.read(pubKeyBytes);

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

			X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pubKeyBytes);
			KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");
			PublicKey pubKey = keyFactory.generatePublic(keySpec);

			// read the digital signature from file
			byte[] digSignBytes = null;
			try (var digSignFIS = new BufferedInputStream(new FileInputStream(digitalSignFile))) {
				digSignBytes = new byte[digSignFIS.available()];
				digSignFIS.read(digSignBytes);

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

			// get the signature
			Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
			// initialise signature with public key
			dsa.initVerify(pubKey);

			// supply signature object with the data to be verified
			byte[] data = new byte[1024];
			int len;
			try (var dataFIS = new BufferedInputStream(new FileInputStream(dataFile))) {
				while (dataFIS.available() != 0) {
					len = dataFIS.read(data);
					dsa.update(data, 0, len);
				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

			// **** verify the data with signature *****
			boolean verified = dsa.verify(digSignBytes);

			System.out.printf("%nDigital Signature Verification: %s", verified ? "Success" : "Failed");

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

		}

	}

	public static void main(String[] args) {

		VerifyDigitalSignature app = new VerifyDigitalSignature();
		app.verifyDigitalSignature(GenerateDigitalSignature.publicKeyFile, GenerateDigitalSignature.digitalSignFile,
				GenerateDigitalSignature.dataFile);
	}

}
