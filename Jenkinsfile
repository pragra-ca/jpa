pipeline {
  agent any
  tools {
    jdk 'jdk11'
    maven 'm3'
  }
  stages {
    stage('Git Checkout') {
      steps {
        sh 'echo "checkoutout"'
      }
    }

    stage('Compile') {
      steps {
        sh 'mvn compile'
      }
    }

  }
}
