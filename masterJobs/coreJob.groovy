pipelineJob('CICD/seed') {
  
  parameters {

    stringParam('ARTIFACT_ID', '', '')
    stringParam('CICD_VERSION', '', '')
    stringParam('NEXUS_REPO', '', '')
    stringParam('FOLDER_PREFIX', '', '')
    stringParam('RELEASE_JOB', '', '')
    stringParam('DRY_RUN', '', '')

/*    validatingStringParameterDefinition {
      name 'ABC'
      regex '^[1-9]*$'
      defaultValue ''
      failedValidationMessage 'Invalid Number'
      description 'enter number'
    }*/
  }

    wrappers {
        preBuildCleanup()
    }

    triggers {
        environmentVariables {
                env('GROUP_ID', 'com.shashi.cicd')
                env('ARTIFACT_VERSION', '${CICD_VERSION}')
                env('NEXUS_URL', 'http://nexus:8080')
            }
    }

    steps {
        shell('echo Hello World!')
    }  

}