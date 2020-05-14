env.gitlab_url = "http://172.24.112.158/lidelong/dcentor.git"
env.gitlab_branch = "*/master"
env.server_replicas = "1"
env.Port = "32306"
env.Appid = "100101"
env.target_dir = "${WORKSPACE}/nlpservice"
env.mountPath = "/data/opt/JAVA"
env.pvcClaim = "nfs-datafile"
env.request_mem = "2Gi"
env.limit_mem = "5Gi"
env.java_Xms = "2g"
env.java_Xmx = "2g"
env.java_Xmn = "1g"
env.MemConf = "-Xms${env.java_Xms} -Xmx${env.java_Xmx} -Xmn${env.java_Xmn} -XX:PermSize=256M -XX:MaxPermSize=512m"
env.JAVA_OPTS="-server ${env.MemConf} -XX:SurvivorRatio=8 -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=512m -XX:+UseParallelGC -XX:ParallelGCThreads=4 -XX:+UseParallelOldGC -XX:+UseAdaptiveSizePolicy -XX:+PrintGCDetails -XX:+PrintTenuringDistribution -XX:+PrintGCTimeStamps -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/ -Xloggc:/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=10M"

env.dockerFile_start="java ${env.JAVA_OPTS} -Denv=${env.release} -Dapp.id=${env.Appid} -Dapollo.configService=${env.Apollo} -Dserver.port=${env.Port} -Djava.security.egd=file:/dev/./urandom -jar /opt/${Service}.jar"
