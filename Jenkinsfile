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

        stage("SonarQube analysis") {
            steps {
                withSonarQubeEnv('sonar') {
                    bat(/mvn clean package sonar:sonar/)
                }
            }
        }

        stage("Quality Gate") {
            steps {
                timeout(time: 60, unit: 'SECONDS') {
                    waitForQualityGate abortPipeline: true
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