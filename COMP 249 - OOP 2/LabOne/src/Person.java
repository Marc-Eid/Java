
public class Person {

	private String name;
	private int age;
	private char gender;
	
	
	
	public Person() 
	{
		name = null;
		age = 0;
		gender = (Character) null;
	}
	
	public Person(Person other)
	{
		name = other.name;
		age = other.age;
		gender = other.gender;
		format();
	}
	
	public Person(String name, int age, char gender)
	{
		for(int i =0; i <name.length(); i++)
		{
			if(name.charAt(i) == ' ')
			{		System.out.println("name should be of one word only");
			System.exit(0);
			}
		}
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		format();
			
	}
	
	
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public char getGender()
	{
		return gender;
	}
	
	
	public boolean equals(Object other)
	{
		if(other == null)
			return false;
		else if(this.getClass() != other.getClass())
			return false;

		else 
		{
			Person otherPerson = (Person) other;
			return (this.name.equals(otherPerson.name) && this.age == otherPerson.age && this.gender == otherPerson.gender );
		}
		
	}
	
	public void setName(String name)
	{
		for(int i =0; i <=name.length(); i++)
		{
			if(name.charAt(i) == ' ')
			{		System.out.println("one word only");
			System.exit(0);
			}
		}
		
		this.name = name;
		format();
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setGender(char gen)
	{
		gender = gen;
	}
	
	
	
	public String toString()
	{
		String gend;
		
		if(gender == 'm')
			gend = "male";
		else
			gend = "female";
		
		return(name + " is " + age + " old and is a " + gend);
		
	}
	
	
	private void format()
	{
		String fix = this.name;
		fix = fix.substring(0,1).toUpperCase() + fix.substring(1);
		this.name = fix;
	}
	
	
	
	
}
