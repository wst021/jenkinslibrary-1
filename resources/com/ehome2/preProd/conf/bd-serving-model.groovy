env.server_replicas = "1"
env.httpPort = "8501"
env.tcpPort = "8500"
env.httpNodePort = "32307"
env.tcpNodePort = "32308"
env.Appid = "100101"
env.REPOSITORY = "${harbor_host}/tensorflow/serving:1.14.0"
env.request_mem = "1Gi"
env.limit_mem = "4Gi"
env.mountPath="/models"
env.pvcClaim="nfs-serving-pvc"

// data operation.
env.credentialsId = "902238e5-1b2b-448e-91ea-c5fbe86c82d9"
env.sourcePath = "/data/nfs/serving-data"
def Tag = sh returnStdout: true, script: "date +%Y%m%d"
Tag = Tag.trim()
env.Tag = "${Tag}"
env.sourceName = "wuxinyu-${Tag}.tgz"
env.remoteAddr = "172.24.112.2"
env.targetPath = "/DATA/nfs/datafile-models"
env.targetName = "multimodel"
env.untarName = "wuxinyu"
