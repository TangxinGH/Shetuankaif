pipeline {


    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
				sh 'mvn  clean install -pl kotlin -am '
                sh 'mvn  kotlin:compile package -pl app -am ' 
            }
        }
    }
}