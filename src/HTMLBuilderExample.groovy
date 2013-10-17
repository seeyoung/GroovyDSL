def writer = new StringWriter()
def html = new groovy.xml.MarkupBuilder(writer)
html.html {
	head { title 'Constructed by MarkupBuilder' }
	body {
		h1 'What can I do with MarkupBuilder?'
		form (action:'whatever') {
			for (line in [
				'Produce HTML',
				'Produce XML',
				'Have some fun'
			]){
				input(type:'checkbox',checked:'checked', id:line, '')
				label(for:line, line)
				br('')
			}
		}
	}
}
println writer
