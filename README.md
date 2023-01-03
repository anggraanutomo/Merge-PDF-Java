# Merge PDFs
A simple program that will merge multiple pdf files into one. This app is built using Java,
[picocli](https://picocli.info/) and [Apache PDFBox](https://pdfbox.apache.org/).

```bash
Usage: MergePDF [-hV] -o=<outputFile> -i=<inputFiles>... [-i=<inputFiles>...]...
Merge PDF files into one PDF file using Apache PDFBox and Picocli
  -h, --help      Show this help message and exit.
  -i, --input=<inputFiles>...
                  Input files to merge.
  -o, --output=<outputFile>
                  Output file.
  -V, --version   Print version information and exit.
```

### Building
The app uses maven as a build tool. To build the app
you must have install maven first and then , run the following command:
```bash
$ mvn clean package
```
This will create a jar file in the target directory with name merge.jar. You can copy this jar file to any directory
and run it from there.

### Example

```bash
java -jar merge.jar -i file1.pdf file2.pdf -o berkasdigabung.pdf
```
[![asciicast](https://asciinema.org/a/HvcC7ue0SpXBJiF7LTw6LMhfs.svg)](https://asciinema.org/a/HvcC7ue0SpXBJiF7LTw6LMhfs)

