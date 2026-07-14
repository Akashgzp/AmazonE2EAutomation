pipeline {

    agent any

    stages {

        stage('Checkout') {

            steps {
                echo 'Source code is already checked out by Jenkins'
            }

        }

        stage('Build & Test') {

            steps {
                bat 'mvn clean test -Pregression'
            }

        }

    }

    post {

        always {
            echo 'Pipeline Finished'
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }

    }

}