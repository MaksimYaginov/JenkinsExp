pipeline {

    agent any

    tools {
        maven 'maven_3.6.0'
        jdk 'jdk1.8.0_171'
    }

    stages {

        stage("SonarQube analysis") {
            steps {
                withSonarQubeEnv('sonar') {
                    bat(/mvn clean package sonar:sonar/)
                }
            }
        }

        stage("Quality Gate") {
            timeout(time: 60, unit: 'SECONDS') {
                def qg = waitForQualityGate()
                if (qg.status != 'OK') {
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
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