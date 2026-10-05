public class EmptyEncryptionKeyException extends StringIndexOutOfBoundsException
{
	public EmptyEncryptionKeyException(String message)
	{
		super(message);
	}

	public EmptyEncryptionKeyException()
	{
		super("Error: Use of an empty encryption key!");
	}

}