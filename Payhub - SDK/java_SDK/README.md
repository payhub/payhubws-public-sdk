# PayHubSDK

Welcome! In this directory, you'll find the files you need to be able to package up our Java library into your server. 

## Usage
* Download the Samples folder.
* Download PayHubSDK.jar
* Open your Eclipse environment and Create a new Maven Project.
* Go to the directory where you saved the Samples folder and add it to your Project.
* Go to Project->Properties->Java Build Path->Libraries and add the PayHubSDK.jar as an external Library.
* Open your pom.xml and then add the next dependencies:

	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-annotations</artifactId>
		<version>2.5.0</version>
	</dependency>
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
		<version>2.5.0</version>
	</dependency>
	<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-core</artifactId>
		<version>2.5.0</version>
	</dependency>

* Update the maven dependencies.
* You're ready to use our SDK.

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/[USERNAME]/PayHubSDK. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the [Contributor Covenant](contributor-covenant.org) code of conduct.

