pipeline {

    agent any

    tools {
            maven 'maven_3.6.0'
            jdk 'jdk1.8.0_171'
        }

    stages {

        stage('Compilation Tests') {
            steps {
                    bat(/mvn clean compile/)
                }
            }

        stage('Run Tests'){
            steps {
                    bat 'mvn clean test'
                }
           }
        }

    post {
         always {
            testng '**/target/surefire-reports/TEST-*.xml'
            archive 'target/*.jar'
            }
        }
}