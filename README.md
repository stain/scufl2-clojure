## scufl2-clojure

Example of using the [Scufl2](http://www.mygrid.org.uk/dev/wiki/display/developer/SCUFL2) [Java API](https://github.com/mygrid/scufl2/) in [Clojure](http://clojure.org/).

Limited functionality for now - simply read and write bundle - returned as a
[uk.org.taverna.scufl2.api.container.WorkflowBundle](http://mygrid.github.com/scufl2/api/0.12/uk/org/taverna/scuafl2/api/container/WorkflowBundle.html)


## Usage

Running unit tests using [Leiningen](http://leiningen.org/):

	stain@biggie:~/src/scufl2-clojure$ lein test

	lein test scufl2.test.core
	Visitting #<WorkflowBundle WorkflowBundle "Hello_World">
	Visitting #<Workflow Workflow "Hello_World">
	Visitting #<OutputWorkflowPort OutputWorkflowPort "greeting">
	Visitting #<Processor Processor "hello">
	Visitting #<OutputProcessorPort OutputProcessorPort "value">
	Visitting #<IterationStrategyStack IterationStrategyStack for Processor "hello">
	Visitting #<DataLink DataLink value=>greeting>
	Visitting #<Revision Revision http://ns.taverna.org.uk/2010/workflow/8781d5f4-d0ba-48a8-a1d1-14281bd8a917/>
	Visitting #<Profile Profile "taverna-2.4.0">
	Visitting #<Activity Activity http://ns.taverna.org.uk/2010/activity/constant "hello">
	Visitting #<OutputActivityPort OutputActivityPort "value">
	Visitting #<ProcessorBinding ProcessorBinding Processor "hello" Activity http://ns.taverna.org.uk/2010/activity/constant "hello">
	Visitting #<ProcessorOutputPortBinding OutputProcessorPort "value"<-OutputActivityPort "value">
	Visitting #<Configuration Configuration "hello">
	Visitting #<Configuration Configuration "hello-proc">

	Ran 3 tests containing 4 assertions.
	0 failures, 0 errors.


## License

* Copyright (C) 2012-2013 Stian Soiland-Reyes

Distributed under the [Eclipse Public License](http://www.eclipse.org/legal/epl-v10.html), the same as Clojure.
