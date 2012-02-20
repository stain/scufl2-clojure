## scufl2-clojure

Example of using the [Scufl2](http://www.mygrid.org.uk/dev/wiki/display/developer/SCUFL2) [Java API](https://github.com/mygrid/scufl2/) in [Clojure](http://clojure.org/).

Limited functionality for now - simply read and write bundle - returned as a
[uk.org.taverna.scufl2.api.container.WorkflowBundle](http://mygrid.github.com/scufl2/api/0.9/uk/org/taverna/scuafl2/api/container/WorkflowBundle.html)


## Usage

Running unit tests using [Leiningen](https://github.com/technomancy/leiningen):

    : stain@ralph ~/src/scufl2-clojure;lein test
    
    Testing scufl2.test.core
    Visitting #<WorkflowBundle TavernaResearchObject [profiles=[Profile "taverna-2.2.0"], mainWorkflow=Workflow [getName()=Hello_World, getDatalinks()=[hello.value=>Hello_World.greeting], getInputPorts()=[], getOutputPorts()=[Hello_World.greeting], getProcessors()=[Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]]]]>
    Visitting #<Workflow Workflow [getName()=Hello_World, getDatalinks()=[hello.value=>Hello_World.greeting], getInputPorts()=[], getOutputPorts()=[Hello_World.greeting], getProcessors()=[Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]]]>
    Visitting #<OutputWorkflowPort Hello_World.greeting>
    Visitting #<Processor Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]>
    Visitting #<OutputProcessorPort hello.value>
    Visitting #<IterationStrategyStack []>
    Visitting #<DispatchStack [DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Parallelize #0 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ], DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/ErrorBounce #1 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ], DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Failover #2 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ], DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Retry #3 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ], DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Invoke #4 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]]>
    Visitting #<DispatchStackLayer DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Parallelize #0 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]>
    Visitting #<DispatchStackLayer DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/ErrorBounce #1 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]>
    Visitting #<DispatchStackLayer DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Failover #2 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]>
    Visitting #<DispatchStackLayer DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Retry #3 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]>
    Visitting #<DispatchStackLayer DispatchStackLayer http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Invoke #4 in Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ]>
    Visitting #<DataLink hello.value=>Hello_World.greeting>
    Visitting #<Profile Profile "taverna-2.2.0">
    Visitting #<Activity Activity http://ns.taverna.org.uk/2010/activity/constant "hello">
    Visitting #<OutputActivityPort OutputActivityPort "value">
    Visitting #<ProcessorBinding ProcessorBinding Processor "hello"[getInputPorts()=[], getOutputPorts()=[hello.value], ] Activity http://ns.taverna.org.uk/2010/activity/constant "hello">
    Visitting #<ProcessorOutputPortBinding ProcessorOutputPortBinding OutputActivityPort "value" -> hello.value>
    Visitting #<Configuration Configuration "hello">
    Visitting #<PropertyResource PropertyResource [getTypeURI()=http://ns.taverna.org.uk/2010/activity/constant#Config, getResourceURI()=null]>
    Visitting #<PropertyVisit PropertyVisit http://ns.taverna.org.uk/2010/activity/constant#string>
    Visitting #<PropertyLiteral PropertyLiteral [getLiteralType()=http://www.w3.org/2001/XMLSchema#string, getLiteralValue()=Hello, World!]>
    Visitting #<Configuration Configuration "hello-dispatch-0">
    Visitting #<PropertyResource PropertyResource [getTypeURI()=http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Parallelize#Config, getResourceURI()=null]>
    Visitting #<Configuration Configuration "hello-dispatch-3">
    Visitting #<PropertyResource PropertyResource [getTypeURI()=http://ns.taverna.org.uk/2010/scufl2/taverna/dispatchlayer/Retry#Config, getResourceURI()=null]>
    
    Ran 3 tests containing 4 assertions.
    0 failures, 0 errors.



## License

* Copyright (C) 2012 Stian Soiland-Reyes
* Copyright (C) 2012 The University of Manchester

Distributed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html), the same as Clojure.
