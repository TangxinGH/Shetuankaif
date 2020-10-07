pipeline {
	agent {
			docker {
				image 'node:6-alpine' 
				args '-p 4000:3000 -v /home/kunpengUI:./dist' 
			}
		}
	stages {
		stage('build') {
			
			steps {
				sh 'ls -a'
				sh 'npm install'
				sh 'npm build'
			}
		}
	}	
}