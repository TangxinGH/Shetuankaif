pipeline {
	agent {
			docker {
				image 'node:current-alpine3.12' 
				args '-p 4000:3000 -v /home/kunpengUI:/dist' 
			}
		}
	stages {
		stage('build') {
			
			steps {
				sh 'ls -a'
				sh 'npm config set registry http://registry.npm.taobao.org'
				sh 'npm install'
				sh 'npm run build'
			}
		}
	}	
}