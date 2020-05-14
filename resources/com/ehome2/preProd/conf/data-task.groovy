env.gitlab_url = "http://172.24.112.158/root/airportehome.git"
//env.gitlab_branch = "*/uat"
env.server_replicas = "1"
env.Port='32171'
env.jmxport='32172'
env.Appid = "1000013"
env.target_dir = "${WORKSPACE}/urm-parent/data-task"
env.RC_Host1 = "172.24.112.13"
env.RC_Host2 = "172.24.112.14"
env.RC_Host3 = "172.24.112.15"
env.RC_HostName1 ="slave01.clab.com"
env.RC_HostName2 = "slave02.clab.com"
env.RC_HostName3 = "slave03.clab.com"
env.request_mem = "1Gi"
env.limit_mem = "8Gi"
env.java_Xms = "3g"
env.java_Xmx = "7g"
env.java_Xmn = "1g"
env.MemConf = "-Xms${env.java_Xms} -Xmx${env.java_Xmx} -Xmn${env.java_Xmn}"
env.JmxConf="-Dcom.sun.management.jmxremote.port=${jmxport} -Dcom.sun.management.jmxremote.rmi.port=${jmxport} -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Djava.rmi.server.hostname=172.24.102.178"

env.JAVA_OPTS="-server ${env.MemConf} ${env.JmxConf} -XX:SurvivorRatio=8 -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m -XX:+UseParallelGC -XX:ParallelGCThreads=4 -XX:+UseParallelOldGC -XX:+UseAdaptiveSizePolicy -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+PrintGCTimeStamps -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/ -Xloggc:/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=10M"

env.dockerFile_start="java ${env.JAVA_OPTS} -Denv=${env.release} -Dapp.id=${env.Appid} -Dapollo.configService=${env.Apollo} -Dserver.port=${env.Port} -Djava.security.egd=file:/dev/./urandom -jar /opt/${Service}.jar"
