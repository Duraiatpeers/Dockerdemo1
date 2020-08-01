pipeline {
    agent any
    tools {
        maven 'C:\\apache-maven-3.6.3' 
    }

    stages {

        stage ('Build') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
