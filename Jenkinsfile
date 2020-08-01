pipeline {
    agent any
    tool name: 'MAVEN_HOME', type: 'maven'
    tool name: 'Javs', type: 'jdk'
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
