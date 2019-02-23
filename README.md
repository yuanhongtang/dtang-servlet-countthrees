export MAVEN_OPTS=-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2

mvn archetype:generate -DgroupId=edu.collegeofsanmateo.cis145 \
-DartifactId=dtang-servlet-coutthrees \
-Dpackage=edu.collegeofsanmateo.cs145 \
-Dversion=1.0 \
-DarchetypeArtifactId = maven-archetype-webapp \
-DinteractiveMode = false \
-Dhttps.protocols=TLSv1.2
