# Install Java

## Homebrew Update

```bash
brew update
```

## Add [adoptopenjdk/openjdk](https://github.com/AdoptOpenJDK/homebrew-openjdk) 

```bash
brew tap adoptopenjdk/openjdk
```

## Search all available jdk

```bash
brew search jdk
```

## Install available jdk version

```bash
brew install --cask adoptopenjdk16
```

## Check installed directory

```bash
/usr/libexec/java_home -V
```

## Check installed Java version

```bash
java --version
```

## Add `JAVA_HOME` environment variable

Open .zshrc with vim

```bash
vi ~/.zshrc
```

Add environment variable

```bash
# Java Paths
export JAVA_HOME_16=$(/usr/libexec/java_home -v16)

# Java 11
export JAVA_HOME=$JAVA_HOME_16
```

Reflect

```bash
source ~/.zshrc
```

## Re-check Java version

```bash
java --version
```

# Set Visual Studio Code

[Install the Coding Pack for Java - macOS](https://aka.ms/vscode-java-installer-mac)

As a result of installation, [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) will be installed.

# Create Maven Project

https://hyunchang88.tistory.com/309

Enter, Y

# SOAP Request / Response Example

Request (Search capital city of Japan)

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <CapitalCity xmlns="http://www.oorsprong.org/websamples.countryinfo">
      <sCountryISOCode>JP</sCountryISOCode>
    </CapitalCity>
  </soap:Body>
</soap:Envelope>
```

Response (Tokyo)

```xml
<?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <m:CapitalCityResponse xmlns:m="http://www.oorsprong.org/websamples.countryinfo">
      <m:CapitalCityResult>Tokyo</m:CapitalCityResult>
    </m:CapitalCityResponse>
  </soap:Body>
</soap:Envelope>
```

