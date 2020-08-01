pipeline {
    agent any
    environment{
        MAVEN_HOME="C:/apache-maven-3.6.3/bin"
    }
    stages {

        stage ('Build') {
            steps {
                echo '${MAVEN_HOME}/mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
