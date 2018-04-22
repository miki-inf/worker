pipelineJob('Worker') {
  publishers {
    Build build = Executor.currentExecutor().currentExecutable
    ParametersAction parametersAction = build.getAction(ParametersAction.class)
    //def targetENV = parametersAction.parameters['ENV'].ParameterValue


  }
    definition {
        cps {
            script(readFileFromWorkspace('/deploy.groovy'))
            //sandbox()
        }
    }

}
