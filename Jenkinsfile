podTemplate(label: 'jenkinsv2-jenkins-agent') {
    node("jenkinsv2-jenkins-agent") {
        stage('Clonar Repositorio') {
            git branch: 'main', url: 'https://github.com/evilDr4gon/project-app-repo.git'
        }

        stage('Construir Imagen Docker') {
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

