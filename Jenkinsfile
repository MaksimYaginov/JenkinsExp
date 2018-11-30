pipeline {

    agent any

    tools {
        maven 'maven_3.6.0'
        jdk 'jdk1.8.0_171'
    }

    stages {

        stage('Tests compilation') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage("SonarQube analysis") {
            steps {
                withSonarQubeEnv('sonar') {
                    bat(/mvn clean verify sonar:sonar/)
                }
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            step([$class: 'Publisher', reportFilenamePattern: '**/target/surefire-reports/testng-results.xml'])
            allure results: [[path: '**/target/allure-results']]
        }
    }
}