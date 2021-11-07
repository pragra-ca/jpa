pipeline {
  agent any
  stages {
    stage('Git Checkout') {
      steps {
        sh 'echo "checkoutout"'
      }
    }

    stage('Compile') {
      steps {
        sh 'sh \'mvn compile\''
      }
    }

  }
}