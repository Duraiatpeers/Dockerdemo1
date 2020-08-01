pipeline {
    agent any
    tools{
        jdk javs
        maven 'MAVEN_HOME'
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
