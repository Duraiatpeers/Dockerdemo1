pipeline {
    agent any
    tools{
        maven 'MAVEN_HOME'
    }
    
    stages {

        stage ('Build') {
            steps {
                echo 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
