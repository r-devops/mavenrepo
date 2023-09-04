pipeline 
{
    agent{ label 'jenkins-slave-1'}
    
    triggers
	{
        pollSCM '* * * * *'
    }
    stages 
		{
        stage('scm checkout')
		{
            steps {
                checkout scmGit(branches: [[name: '*/feat1']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/itssanthosh44/mavenrepo.git']])
            }
        }
        stage ('build'){
            steps {
                sh 'mvn package'
            }
        }    
		
		stage ('uploadArtifactory') 
		{
			steps {
			sh 'mvn deploy'
			}
		}
		stage ('installApplication')
		{
		steps {
			sh 'scp /root/workspace/build1/feature1/target/*.war root@172.31.94.169:/opt/apache-tomcat-9.0.55/webapps'
			  }
		}
		
			stage('postBuildNotification')
		{
				steps{
				emailext body: '$DEFAULT_CONTENT', subject: '$DEFAULT_SUBJECT', to: 'patnalasantosh97@gmail.com, yadamshashi@gmail.com'
			}
		}
		
    }
}
