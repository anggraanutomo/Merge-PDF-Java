package id.anggra;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

@Command(name = "MergePDF", mixinStandardHelpOptions = true, version = "MergePDF 1.0",
        description = "Merge PDF files into one PDF file using Apache PDFBox and Picocli")
public class MergePDF implements Runnable
{
    @Option(names = {"-i", "--input"}, arity = "1..*" ,required = true, description = "Input files to merge.")
    private String[] inputFiles;

    @Option(names = {"-o", "--output"}, required = true, description = "Output file.")
    private String outputFile;

    public static void main(String[] args)
    {
        int exitCode = new CommandLine(new MergePDF()).execute(args);
        System.exit(exitCode);
    }

    public void run()
    {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        pdfMerger.setDestinationFileName(outputFile);

        for (String inputFile : inputFiles)
        {
            try
            {
                pdfMerger.addSource(inputFile);
            }
            catch (FileNotFoundException e)
            {
                System.err.println("File not found: " + inputFile);
            }
        }

        try
        {
            pdfMerger.mergeDocuments();
        }
        catch (IOException e)
        {
            System.err.println("Error merging PDF files: " + e.getMessage());
        }
    }
}
