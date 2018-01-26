###Remember

####build.gradle
```
    //proxy
            maven {
                url "http://maven.oa.com/nexus/content/groups/androidbuild"
            }
    
    //no proxy
              google()
              jcenter()
```

####gradle-wrapper.properties
```
#no proxy
distributionUrl=https\://services.gradle.org/distributions/gradle-4.1-all.zip

#proxy
distributionUrl=http\://android.oa.com/gradle/gradle-4.1-all.zip
systemProp.http.proxyHost=dev-proxy.oa.com
systemProp.http.proxyPort=8080
systemProp.http.nonProxyHosts=*.oa.com|localhost

systemProp.https.proxyHost=dev-proxy.oa.com
systemProp.https.proxyPort=8080
systemProp.https.nonProxyHosts=*.oa.com|localhost
```
