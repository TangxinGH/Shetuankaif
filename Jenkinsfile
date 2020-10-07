pipeline {


    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2 -v /home/kunpengUI:/var/jenkins_home/workspace/kunpengshetuan/app/src/main/resource/public' 
        }
    }
    stages {
        stage('Build') { 
            steps {
				sh ' mvn clean kotlin:compile package -Dmaven.test.skip=true'
            }
        }
    }
}