### Installation

#### Installing Groovy on Unix (Mac OSX, Linux, Solaris or FreeBSD)

The preferred method of installing Groovy is [SDKman](http://sdkman.io/).

Detailed instructions can be found [here](https://sdkman.io/install/).  Briefly, open a shell and issue:

1. `curl -s "https://get.sdkman.io" | bash`
1. `source "~/.sdkman/bin/sdkman-init.sh"`
1. `sdk install java`
1. `sdk install groovy`

Side note: this method is also suitable for Cygwin on Windows

#### Installing Groovy on Windows

1. You should have JDK installed and `JAVA_HOME` environment variable set correctly. 
You can test it by issuing `javac -v` command. 
To install JDK follow [this instructions](https://docs.oracle.com/javase/8/docs/technotes/guides/install/windows_jdk_install.html)
1. Download Windows Installer from [Groovy Download page](http://groovy-lang.org/download.html)
1. Make sure Groovy is accessible in your console by issuing `groovy -v`
1. If you receive an error message saying `'groovy' is not recognized as an internal or external command` 
you'll have to set `GROOVY_HOME` environment variable as described [here](http://groovy-lang.org/install.html#_install_binary)

Other methods of installing Groovy can be found [here](http://groovy-lang.org/install.html).
