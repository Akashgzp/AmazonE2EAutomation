pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven-3.9.16'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Test') {
            steps {
                bat "mvn clean test -P${params.SUITE}"
            }
        }

    }

  post {

    always {
        junit '**/surefire-reports/*.xml'

        publishHTML(target: [
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'reports',
            reportFiles: 'AutomationReport.html',
            reportName: 'Extent Report'
        ])
    }

    success {
        emailext(
            subject: "SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """
Build Successful

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
URL: ${env.BUILD_URL}
""",
            to: 'akashgzp196@gmail.com'
        )
    }

    failure {
        emailext(
            subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: """
Build Failed

Job: ${env.JOB_NAME}
Build Number: ${env.BUILD_NUMBER}
URL: ${env.BUILD_URL}
""",
            to: 'your-email@gmail.com'
        )
    }
  }
}