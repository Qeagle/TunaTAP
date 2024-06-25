pipeline {
  agent any
  stages {
    stage('QA Build') {
      steps {
        sleep 1
        echo 'Build Deployed'
      }
    }

    stage('QA Tests') {
      parallel {
        stage('API Tests') {
          steps {
            echo 'API Tests'
          }
        }

        stage('UI Testst') {
          steps {
            echo 'UI Tests'
          }
        }

        stage('Performance Tests') {
          steps {
            echo 'Jmeter Tests'
          }
        }

      }
    }

    stage('UAT Build') {
      steps {
        echo 'UAT Build'
      }
    }

    stage('UAT Tests') {
      parallel {
        stage('Integration Tests') {
          steps {
            echo 'UAT'
          }
        }

        stage('E2E Tests') {
          steps {
            echo 'E2E'
            echo 'E2E Tests'
          }
        }

      }
    }

    stage('Approval Gate') {
      steps {
        input(message: 'Approval', id: '123', ok: 'Approved')
      }
    }

  }
}