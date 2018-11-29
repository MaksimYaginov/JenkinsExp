pipeline {
agent any
stages {
        stage('Compilation') {
            steps {
                withMaven(maven: 'maven_3.6.0'){
                if (isUnix()) {
                     sh "mvn clean compile"
                  } else {
                    bat(/mvn clean compile/)
                    }
                }
            }
        }

        stage('Test'){
            steps {
                withMaven(maven: 'maven_3.6.0') {
                    bat 'mvn clean test'
                    te 'reports/**/*.xml'
                }
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