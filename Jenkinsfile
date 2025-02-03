pipeline {
    agent {
        label 'jenkinsv2-jenkins-agent'
    }

    triggers {
        githubPush() // Activa el pipeline cuando haya un push
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                withCredentials([string(credentialsId: 'github-token', variable: 'GITHUB_TOKEN')]) {
                    sh '''
                    git config --global credential.helper 'cache --timeout=3600'
                    git config --global user.name "jenkins"
                    git config --global user.email "jenkins@example.com"
                    git clone https://$GITHUB_TOKEN@github.com/evilDr4gon/project-app-repo.git .
                    '''
                }
            }
        }

        stage('Construir Imagen Docker') {
            steps {
                container('dind') {
                    sh '''
                    echo "🐳 Construyendo imagen Docker..."
                    docker build -t mi-quarkus-app:latest .

                    echo "📸 Listando imágenes Docker..."
                    docker images
                    '''
                }
            }
        }
    }
}

