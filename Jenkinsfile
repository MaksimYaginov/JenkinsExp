pipeline {

    agent any

    tools {
            maven 'maven_3.6.0'
            jdk 'jdk1.8.0_171'
        }

    stages {

        stage('Compilation') {
            steps {
                    bat(/mvn clean compile/)
                }
            }

        stage('Test'){
            steps {
                    bat 'mvn clean test'
                }
           }

        stage('Results'){
             steps {
                testng '**/target/surefire-reports/TEST-*.xml'
                archive 'target/*.jar'
             }
         }
    }
}