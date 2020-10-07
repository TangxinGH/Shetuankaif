pipeline {

	agent none
  
    stages {
		stage('download') {
			agent {
				docker {
					image 'node:6-alpine' 
					args '-p 4000:3000 -v /home/kunpengUI:/Shetuankaif/dist' 
				}
			}
			steps {
				sh 'git clone -b kunpengUI https://gitee.com/mai-tao/Shetuankaif.git'
				sh 'ls -a'
				sh ' cd Shetuankaif'
				sh 'npm install'
				sh 'npm build'
			}
		}
        stage('Build') { 
			agent {
				docker {
					image 'maven:3-alpine' 
					args '-v /root/.m2:/root/.m2' 
				}
			}
            steps {
				sh 'ls -a'
				sh ' cp /home/kunpengUI/* app/src/main/resource/public'
				sh ' mvn clean kotlin:compile package -Dmaven.test.skip=true'
            }
        }
    }
}