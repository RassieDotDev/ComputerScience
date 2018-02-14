use strict;
use warnings;
my $file;
my $counter = 1;
my @files = `ls -I*.pl`;
foreach $file (@files){
	chomp($file);
	print `mv $file $counter.fil`;
	$counter += 1;
}
