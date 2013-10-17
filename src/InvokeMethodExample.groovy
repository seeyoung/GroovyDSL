import org.codehaus.groovy.runtime.StringBufferWriter
import org.codehaus.groovy.runtime.InvokerHelper
class Traceable implements GroovyInterceptable {
	Writer writer = new PrintWriter(System.out)
	private int indent = 0
	Object invokeMethod(String name, Object args){
		writer.write("\n" + ' '*indent + "before method '$name'")
		writer.flush()
		indent++
		def metaClass = InvokerHelper.getMetaClass(this)
		def result = metaClass.invokeMethod(this, name, args)
		indent--
		writer.write("\n" + ' '*indent + "after method '$name'")
		writer.flush()
		return result
	}
}
class Whatever extends Traceable {
	int outer(){
		return inner()
	}
	int inner(){
		return 1
	}
}
def log = new StringBuffer()
def traceMe = new Whatever(writer: new StringBufferWriter(log))
assert 1 == traceMe.outer()
println log
