pipeline {

	agent none
    
    stages {
	

		stage('node'){
			agent {
				
				dockerfile {
					filename 'dockerfile'
					
				}
			
			}
		
			steps {
					sh 'tree -P app -d -L 6 '
					sh 'rm -rf Shetuankaif'
					sh ' git clone -b kunpengUI https://gitee.com/mai-tao/Shetuankaif.git'
					sh 'cd Shetuankaif '
					sh 'tree -d -L 6 -I '*node_module|.git|tests' '
					sh 'npm install'
					sh 'npm run build'
					sh 'tree -d -L 6 ../'
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
