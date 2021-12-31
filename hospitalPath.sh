# kill old progress
echo "*************1. kill old progress****************"
ps -aux|grep 'java -jar hospital-0.0.1-SNAPSHOT.jar'|grep -v grep|awk '{print$2}'|xargs kill -9
# update code
echo "*************2. update code****************"
git pull
# compile and package
echo "*************3. compile and package****************"
cd pathManagement
mvn clean package -Dmaven.test.skip=true
cd pathManagement/target
# run
echo "*************4. run****************"
nohup java -jar hospital-0.0.1-SNAPSHOT.jar &> hospitalPath.log &
