pipeline {

	agent none
    
    stages {
	

		stage('node'){
			agent {
				
				dockerfile {
					filename 'dockerfile'
					dir 'UIbuild'
					
					additionalBuildArgs  '--build-arg version=1.0.2'
					args ' -v /home/kunpengUI:/home/kunpengUI/'
				}
			
			}
		
			steps {
					sh ' git clone -b kunpengUI https://gitee.com/mai-tao/Shetuankaif.git'
					sh 'cd Shetuankaif '
					sh 'npm install'
					sh 'npm run build'
					sh 'rm -rf ../app/src/main/resource/public/*'
					sh ' mv dist/* ../app/src/main/resource/public'
					sh 'cd ../'
					sh 'rm -rf Shetuankaif'
				}
        }
	
        stage('Build') { 
			agent {
				docker {
					image 'maven:3-alpine' 
					args '-v /root/.m2:/root/.m2 -v /home/kunpengUI:/var/jenkins_home/workspace/kunpengshetuan/app/src/main/resource/public' 
				}
			}
            steps {
				sh ' mvn clean kotlin:compile package -Dmaven.test.skip=true'
            }
        }
		
	}
	
}
