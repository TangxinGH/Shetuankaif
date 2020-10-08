pipeline {

	agent none
        environment { 
        CC = 'clang'
    }
    stages {
	

		stage('node'){
			agent {
				
				dockerfile {
					filename 'dockerfile'
					
				}
			
			}
		
			steps {
					sh 'ls '
					
					sh 'rm -rf Shetuankaif'
					sh ' git clone -b kunpengUI https://gitee.com/mai-tao/Shetuankaif.git'
					sh 'ls'

					
					sh "ls  "
					sh 'npm install --prefix ./Shetuankaif'
					sh 'npm run build ./Shetuankaif'
					
					sh 'rm -rf ../app/src/main/resource/public/*'
				}
        }
        stage('Build') { 
			agent {
				docker {
					image 'maven:3-alpine' 
					args '-v /root/.m2:/root/.m2 ' 
				}
			}
            steps {
				sh ' mvn clean kotlin:compile package -Dmaven.test.skip=true'
            }
        }
		
	}
	
}
